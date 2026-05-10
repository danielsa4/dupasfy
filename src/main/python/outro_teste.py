
abc = 'abcdefghijklmnopqrstuvwxyz'
zero = ''
quatro = ''
igual = ''

for x in range(0, len(abc)):
    zero = x % 26
    quatro = (x+4) % 26
    igual = (x+4+9) % 26
    print(str(abc[zero])+str(abc[quatro])+str(abc[igual]), 
          str(abc[igual])+str(abc[zero])+str(abc[quatro]), 
          str(abc[igual])+str(abc[zero])+str(abc[quatro])+str(abc[igual]), 
          str(abc[zero])+str(abc[quatro])+str(abc[igual])+str(abc[zero]), 
          str(abc[quatro])+str(abc[igual])+str(abc[zero]))
