var http = require('http');
http.createServer(function(req,res){
res.writeHead(200, {'content-Type' : 'text/plain'});
res.end ('Hello World');
}).listen(8080);

console.log("started server on locahost 8080; press ctrl-c to terminate")

function sayHello(name){
console.log('Hello ' + name)
}

sayHello('josh')
