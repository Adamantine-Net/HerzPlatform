#!/usr/bin/env bash
set -e

echo "restoring module-eag-1_8 and module-eag-1_14 into modules/ ..."

mkdir -p modules

git submodule deinit -f modules/module-eag-1_8 2>/dev/null || true
git submodule deinit -f modules/module-eag-1_14 2>/dev/null || true

rm -rf .git/modules/modules/module-eag-1_8
rm -rf .git/modules/modules/module-eag-1_14

git submodule update --init --recursive

echo "done, checking whats there now:"
ls modules
