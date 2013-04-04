#!/usr/bin/env bash

set -e

dependencies=('ant' 'unzip' 'jar' 'svn')
for app in ${dependencies[@]}; do
  hash $app 2>/dev/null || {
    echo >&2 "Required application $app it not installed.";
    exit 1;
  }
done


while true; do
    read -p "Be advised, this checkout will take very long (~1 hour or more). Continue? y/n" yn
    case $yn in
        [Yy]* ) mkdir -p build/ai/vocals && cd build/ai/vocals && \
                svn checkout svn://svn.code.sf.net/p/cmusphinx/code/trunk cmus4
                break;;

        [Nn]* ) exit;;
        * ) echo "Please answer yes or no.";;
    esac
done


echo "
java -cp resources/clojure.jar:build/ai/vocals/cmus4/lib/jsapi-1.0-base.jar:\
  build/ai/vocals/cmus4/lib/sphinx4.jar\
  clojure.main\
  ClojureTranscriber.clj
"
