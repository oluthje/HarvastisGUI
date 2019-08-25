import random
import time

class Test2:
	def __init__(self):
		self.running = 1

		self.old_variable = 0
		self.variable = 0

		while self.running == 1:
			self.start()

	def check_if_variable_changed(self):
		if self.old_variable != self.variable:
			print("variable changed!")
		else:
			print("no variable change :(")
		self.old_variable = self.variable

	def change_variable(self):
		print("randomly updating variable...")
		time.sleep(1)
		rand_num = random.randint(1,101)
		if rand_num > 60:
			if self.variable == 0:
				self.variable = 1
			else:
				self.variable = 0
		self.check_if_variable_changed()


	def start(self):
		self.change_variable()




test = Test2()