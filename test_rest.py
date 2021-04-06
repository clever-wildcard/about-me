import requests

response = requests.post("http://localhost:8080/comments", json={"author": "me", "comment": "this is a comment"})
print(response.status_code)
print(requests.get("http://localhost:8080/comments").json())