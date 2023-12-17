import re
import regex
# games= {}
cubesTypes = ['red','blue','green']
gamelist = []
required = {
    'red': 12,
    'green': 13,
    'blue': 14
}

with open('./data.txt','r') as f:
    contents = f.read().split('\n')
    # print(re.split(':|;',contents[0]))
    
    for i in contents:
        games=dict([(i.split(":")[0],re.split(':|;',i)[1::]) for i in contents])
    keys = list(games.keys())
    # print(regex.search(r'\bgreen\b', games[keys[0]]))
    print(games[keys[0]])
    if 'green' in games[keys[0]][0]:
        print('hey')
    for key in keys:
        if games[keys[0]].__contains__                              
