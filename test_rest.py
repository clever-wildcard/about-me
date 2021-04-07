import requests

response = requests.post("http://localhost:8080/comments", json={"author": "me", "content": "this is a comment"})
print(response.status_code)
response = requests.post("http://localhost:8080/comments", json={"author": "", "content": "this is a comment"})
print(response.status_code)
print(requests.get("http://localhost:8080/comments").json())