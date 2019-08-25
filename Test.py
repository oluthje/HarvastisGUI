import os

file1 = open("pythonjava.txt","a+")
file1.close()

class Test:
	def __init__(self):
		self.input = None
		self.output = None
		self.running = 1

		while self.running == 1:
			self.prompt_user()
			self.send_to_backend()
			self.retrieve_from_backend()
			print(self.output)

	def prompt_user(self):
		user_input = raw_input("Please enter your name: ")
		type(user_input)
		self.input = user_input

	def send_to_backend(self):
		file = open("pythonjava.txt","w+")
		file.write(self.input)
		file.close()
		os.system("javac Test.java")
		os.system("java Test")

	def retrieve_from_backend(self):
		file = open("pythonjava.txt","r+")
		self.output = file.read()
		file.close()

test = Test()