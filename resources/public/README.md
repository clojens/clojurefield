
This web folder contains some solutions which should, each in their own way,
make it a lot easier to deal with certain use-cases. The delicate matter is,
when do we use what approach when we have the power of Clojure, Java and the
Node ecosystem at our fingertips?

Take 'sieve'. Sieve is an implementation of the sieve of Eratosthenes, it finds
prime numbers for you.

!["Test comparison"][http://i.imgur.com/BkTG0.png]

> The more interesting part is how differently exponential it is with the same
> algorithm in different runtime environments. I have no idea what’s going on
> with node.js on those large datasets. Both algorithms seem to be running on a
> nice exponential curve and then BAM, shoots through the roof and even dies
> completely. Whereas Clojure’s biggest problem with the small datasets is
> apparently the run-up time itself and then it continues growing on a
> predictable exponential curve.

This illustrates some conclusions we can reach:

> Node better for small bursts of activity and clojure better for more
> sustained hardcore work.

### List of solutions reviewed up to now and included for this purpose:

* clojure-script :: The 'other' side implementation with Google Closure Compiler
* coffee-script :: For short-hand significant white-space hack scripts together
* natural :: Natural language in Node.js with Classier, Treebank and such tools
* sieve :: Eratosthenes efficient algorithm for calculating primes at high speed

