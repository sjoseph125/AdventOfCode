import re
import regex

"""
stripped = []
singleNums = []
doubleNums = []
firstTwo = []
patterns = []
wordNums = []
wordList = ['\d*(one|two|three|four|five|six|seven|eight|nine)\d*']
pattern1 = re.compile(wordList[0])
def replaceWords(i): 
    pattern1.match(i)
    for t in patterns:
    # print(patterns)
        # print(pattern)
        if pattern1.match(i):
            # print(i)
            wordNums.append(i)
        else:
            stripped.append(re.sub('[a-z]',"",i).splitlines())

        # print(pattern.match(i))


for i in wordList:
    patterns.append(re.compile(i))
with open('./data.txt','r') as f:
    contents = f.read().split('\n')
    for i in contents:
        replaceWords(i)
    
    # print(stripped)
    # print(wordNums)
for x in wordNums:
    print('x', x)
    print(re.findall(wordList[0],x))
    
for i in range(len(stripped)):
    if len(stripped[i][0]) == 1:
        singleNums.append(stripped[i][0]*2)
    else:
        doubleNums.append(stripped[i][0]) 

for i in doubleNums:
    # print(re.findall('^\d',i))
    first = re.findall('^\d',i)
    last = re.findall('\d$',i)
    # print(re.findall('\d{2}',i))
    firstTwo.append(first[0]+last[0])

# print(len(singleNums))
# print(firstTwo)

totalCount = 0

for i in singleNums:
    totalCount+= int(i)
    # print(totalCount)

for i in firstTwo:
    totalCount+= int(i)
print(totalCount)
"""

def findTotalOne(x):
    res = regex.findall(r"\d", x)
    print(res[0]+ res[-1])
    return int(res[0] + res[-1])

print(sum(map(findTotalOne, open("data.txt"))))