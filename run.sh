#! /bin/bash

PHOME=/home/yu/workspace/ChineseWordSegmentation
cp=`echo "
$PHOME/bin
$PHOME/lib/ansj_lucene.jar
$PHOME/lib/nlp-lang-0.3.jar
$PHOME/lib/word-1.3.jar
$PHOME/lib/woodstox-core-asl-4.4.1.jar
$PHOME/lib/ansj_seg-2.0.8.jar
$PHOME/lib/tree_split-1.1.1.jar
" | grep -v "^#" | xargs | tr ' ' ':'`
set -x
java -classpath "$cp" cWS.cwSegmentation
