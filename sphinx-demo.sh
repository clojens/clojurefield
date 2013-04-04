#!/usr/bin/env bash

set -e

dependencies=('ant' 'unzip' 'jar' 'svn')
for app in ${dependencies[@]}; do
  hash $app 2>/dev/null || {
    echo >&2 "Required application $app it not installed.";
    exit 1;
  }
done

mkdir -p build/speech && \
cd build/speech && \
svn checkout svn://svn.code.sf.net/p/cmusphinx/code/trunk cmusphinx


java -cp resources/clojure.jar:build/speech/cmusphinx/lib/jsapi-1.0-base.jar:\
  build/speech/cmusphinx/lib/sphinx4.jar\
  clojure.main\
  resources/ClojureTranscriber.clj
