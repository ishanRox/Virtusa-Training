import re


regex=re.compile('''(\d{2})(\w{2})''')

print(regex.findall('12df 44ff 53cv'))
results=regex.sub(r'\2\1','12df 44ff 53cv')
#swapping is done
print(results)