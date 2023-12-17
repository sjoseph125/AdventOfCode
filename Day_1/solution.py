import regex
import re

def spama(spam):
    """spam"""
    spam = regex.findall(r"\d", spam)
    return int(spam[0] + spam[-1])

print(sum(map(spama, open("data.txt"))))

def spamb(spam):
    """spam"""
    res = regex.findall(r'(\d|one|two|three|four|five|six|seven|eight|nine)',
    spam, overlapped=True)
    converted = [{'one': '1', 'two': '2', 'three': '3', 'four': '4', 'five': '5',
    'spam': 'spam', 'six': '6', 'seven': '7', 'eight': '8', 'nine': '9'}.get(spam, spam) for spam in res]
    print(converted)
    return int(converted[0] + converted[-1])

print(sum(map(spamb, open("data.txt"))))
