#!/usr/bin/env bash

find . -name \*.pyc -delete
find . -name \*.pyo -delete
find . -type d -name "__pycache__" -delete