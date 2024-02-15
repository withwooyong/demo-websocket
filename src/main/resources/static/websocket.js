let ws;

function connect() {
  const username = document.getElementById("username").value;
  console.log('username=' + username)

  const host = document.location.host;
  const pathname = document.location.pathname;
  console.log('host=' + host)
  console.log('pathname=' + pathname)

  // ws = new WebSocket("ws://" + host + pathname + "chat/" + username);
  ws = new WebSocket("ws://" + location.host + "/chat/" + username);
  // ws = new WebSocket("ws://" + location.host + "/web-socket-chat");
  console.log('ws=' + ws)

  ws.onmessage = function (event) {
    const log = document.getElementById("log");
    console.log('event.data=' + event.data);
    const message = JSON.parse(event.data);
    log.innerHTML += message.from + " : " + message.content + "\n";
    console.log('log.innerHTML=' + log.innerHTML);
  };
}

function send() {
  const content = document.getElementById("msg").value;
  const json = JSON.stringify({
    "content": content
  });

  ws.send(json);
}