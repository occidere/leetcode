#!/bin/bash
if ((`head -n 10 file.txt | wc -l` < 10)); then
    echo ''
else
    head -n 10 file.txt | tail -n 1
fi
