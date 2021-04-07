import requests
import sys

response = requests.post('http://locahost:8080/comments', json={'author': sys.argv[0], 'comment': sys.argv[1]})