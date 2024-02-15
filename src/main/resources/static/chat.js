let ws;

function connect() {
  const username = document.getElementById("username").value;
  console.log(username)

  const host = document.location.host;
  const pathname = document.location.pathname;
  console.log(host)
  console.log(pathname)

  // ws = new WebSocket("ws://" + host + pathname + "chat/" + username);
  // ws = new WebSocket("ws://" + location.host + "/chat/" + username);
  ws = new WebSocket("ws://" + location.host + "/web-socket-chat");

  ws.onmessage = function (event) {
    const log = document.getElementById("log");
    console.log(event.data);
    const message = JSON.parse(event.data);
    log.innerHTML += message.from + " : " + message.content + "\n";
  };
}

function send() {
  const content = document.getElementById("msg").value;
  const json = JSON.stringify({
    "content": content
  });

  ws.send(json);
}