#!/usr/bin/env bash

set -e

dependencies=('ant' 'unzip' 'jar' 'svn')
for app in ${dependencies[@]}; do
  hash $app 2>/dev/null || {
    echo >&2 "Required application $app it not installed.";
    exit 1;
  }
done

echo "Be advised, this checkout will take very long (~1 hour or more). Install?"
select yn in "Yes" "No"; do
    case $yn in
        Yes ) mkdir -p build/ai/vocals && cd build/ai/vocals && \
              svn checkout svn://svn.code.sf.net/p/cmusphinx/code/trunk cmus4; break;;
        No ) exit;;
    esac
done

echo "You should be able to run the demo now using:
---------------------------------------------
java -cp resources/clojure.jar:build/ai/vocals/cmus4/lib/jsapi-1.0-base.jar:\
  build/ai/vocals/cmus4/lib/sphinx4.jar\
  clojure.main\
  ClojureTranscriber.clj
"
