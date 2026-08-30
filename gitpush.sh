!#/bin/bash

git add .
echo "Enter a git commit message: "
read message
git commit -m $message
git push
