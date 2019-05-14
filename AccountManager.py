import time
import json
import os
import subprocess

while True:
	if not os.path.isfile("accounts.csv"):
		print("No accounts file. Exiting...")
		exit()
	else:
		with open("accounts.csv", "r") as f:
			accounts = f.read().split("\n")

	i = 0
	for account in accounts:
		check = account.split(",")
		if check[2] == 'TRUE':
			i = i + 1
		else:
			break;


	if not accounts: ## or equals \n
		print("Out of accounts")
		exit()

	if not os.path.isfile("LauncherQuickLaunch.json"):
		print("No json file. Exiting...")
		exit()
	else:
		with open("LauncherQuickLaunch.json", "r+") as f:
			settings = json.load(f)
			settings['Clients'][0]['RsUsername'] = accounts[i].split(",")[0]
			settings['Clients'][0]['RsPassword'] = accounts[i].split(",")[1]
			f.seek(0)
			json.dump(settings, f, indent = 4)
			f.truncate()

	subprocess.call(['java','-jar', '/home/zoruda/Coding/Runescape/RSPeer1.0.1.jar', '/home/zoruda/Coding/Runescape/Zoruda-s-Tutorial-Island/LauncherQuickLaunch.json'])