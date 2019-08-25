from Tkinter import *
import os

class Gameboard:
	def __init__(self, master):
		self.master = master

		self.game_board_sizex = None
		self.game_board_sizey = None
		self.square = None
		
		self.file = None
		self.scene = None
		self.sceneMessage = None
		self.sceneInfo = None

		self.raw_scene = None

		self.main_frame = Frame(self.master, padx=25, pady=25)
		self.main_frame.bind("<Key>", self.key_down)
		self.main_frame.bind("<Return>", self.return_down)
		self.main_frame.focus_set()
		self.main_frame.pack()

		self.board_frame = Frame(self.main_frame, bd=1, relief=GROOVE, padx=10, pady=5)
		self.board_frame.pack()
		self.some_label = Label(self.main_frame, text="Hello world!")
		self.some_label.pack()
		self.some_button = Button(self.main_frame, text="niet", command=self.load_game_board)
		self.some_button.pack()

		self.load_game_info()
		self.get_variables_from_file_str()
		self.translate_scene_to_array()

		#self.load_game_board()

	def return_down(self, event):
		print("pressed return")
		self.save_keypress_to_file("Return")

	def key_down(self, event):
		if event.char == "w":
			print("pressed w")
			self.save_keypress_to_file(event.char)
		elif event.char == "a":
			print("pressed a")
			self.save_keypress_to_file(event.char)
		elif event.char == "s":
			print("pressed s")
			self.save_keypress_to_file(event.char)
		elif event.char == "d":
			print("pressed d")
			self.save_keypress_to_file(event.char)

	def save_keypress_to_file(self, key):
		txtfile = open("toJavaGame.txt","w")
		txtfile.write(key)
		txtfile.close()

	def load_game_info(self):
		# open toPythonGUI.txt and get all variables using string slicing print(string[10:15])
		txtfile = open("toPythonGUI.txt","r+")
		self.file = txtfile.read()
		txtfile.close()

	def get_variables_from_file_str(self):
		temp_var = None

		scene_in_file_index = self.file.find("scene:")
		sceneMessage_in_file_index = self.file.find("sceneMessage:")
		sceneInfo_in_file_index = self.file.find("scene:")

		self.scene = self.file[scene_in_file_index:sceneMessage_in_file_index]
		temp_var = self.scene.replace("scene:","")
		self.scene = temp_var
		print(self.scene)

	def find_scene_dimensions(self):
		# finds width of scene game: self.game_board_sizex
		scene_first_line = self.scene.find("\n")
		self.game_board_sizex = scene_first_line - 2
		print(self.game_board_sizex)

		# finds height of scene game: self.game_board_sizey
		num_of_chars_in_scene = len(self.scene)
		self.game_board_sizey = num_of_chars_in_scene/scene_first_line
		print(self.game_board_sizey)

		# makes self.square to necessary size
		self.square = [[0 for x in range(self.game_board_sizex)] for y in range(self.game_board_sizey)]

	def remove_unnecessary_chars_from_scene(self):
		# use self.raw_scene
		self.raw_scene = self.scene.replace("|","")
		self.raw_scene = self.raw_scene.replace("\n","")
		print(self.raw_scene)

	def translate_scene_to_array(self):
		self.find_scene_dimensions()
		self.remove_unnecessary_chars_from_scene()

		# translate self.scene into a 2d array

		index = 0
		for y in range(self.game_board_sizey):
			for x in range(self.game_board_sizex):
				print("x: " + str(x) + "| y: " + str(y) + " " + self.raw_scene[index])
				self.square[y][x] = self.raw_scene[index]
				index += 1

		print(self.square)

	def load_game_board(self):
		for y in range(self.game_board_sizey):
			for x in range(self.game_board_sizex):
				label_text = self.square[y][x]
				self.label = Label(self.board_frame, text=label_text, font=("Courier", 35), borderwidth=1,)
				self.label.grid(row=y,column=x)

root = Tk()
Gameboard = Gameboard(root)
root.mainloop()



