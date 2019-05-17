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
			print(accounts[i].split(",")[3])
			if accounts[i].split(",")[3] == "0":
				settings['Clients'][0]["UseProxy"] = "false"
			elif accounts[i].split(",")[3] == "1":
				settings['Clients'][0]["UseProxy"] = "true"
				settings['Clients'][0]['ProxyIp'] = "108.187.189.144"
				settings['Clients'][0]['ProxyPort'] = "8000"
				settings['Clients'][0]['ProxyUser'] = "6wBZb5"
				settings['Clients'][0]['ProxyPass'] = "NTsj9a"

			f.seek(0)
			json.dump(settings, f, indent = 4)
			f.truncate()

	subprocess.call(['java','-jar', '/home/zoruda/Coding/Runescape/RSPeer1.0.1.jar', '/home/zoruda/Coding/Runescape/Zoruda-s-Tutorial-Island/LauncherQuickLaunch.json'])