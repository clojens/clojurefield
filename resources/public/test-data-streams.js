// tubber.js
var tub = require('tub');
var splitter = require('splitter')
var onFinish = function (res) {
  console.log(res);
  process.exit(res.ok ? 0 : 1)
};
process.stdin
  .pipe(splitter())
  .pipe(tub(onFinish))
  .pipe(process.stdout);
