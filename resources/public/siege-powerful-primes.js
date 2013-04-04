#!/usr/bin/env node

var sieve = require('sieve');

// primes from 2 to 1000000
var primes = sieve(1000000);

// primes from 100 to 1000000
var title= "Loop on numbers"
var t = process.hrtime;
console.time(title);
var primes = sieve(1000000, 100);
console.log(primes);
var t1 = process.hrtime(t);
console.log("%s %d seconds and %d nanoseconds", title, t1[0], t1[1]);
