
# Leetcode problem number: 273 Integer to english
# idea in english for number billion XXX million XXX thousand
# in between each it's for 3 digits could be one hundred twenty nine or one hundred thirty or twenty nine

a = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
b = ["","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]

def getString(num):
	result = ""
	power = 2
	r1 = num % pow(10,power)
	n1 = num / pow(10,power)
	if(n1 > 0):
		result = result+a[n1]+" Hundred "
	if(r1 > 19):
		power -= 1
		num = r1
		r2 = num % pow(10,power)
		n2 = num / pow(10,power)
		if(r2 > 0):
		    result = result+b[n2]+" "+a[r2]
		else:
		    result = result+b[n2]
	else:
		result= result+a[r1]
	return result.strip()

class IntegerToEnglish(object):
    def numberToWords(self, num):
        result = ""
        if(num == 0):
            return "Zero"
    	power = 9
    	r0 = num % pow(10,power)
    	n0 = num / pow(10,power)
    	if(n0 > 0):
    	    result = getString(n0)+ " Billion "
    	power-= 3
    	num = r0
    	r1 = num % pow(10,power)
    	n1 = num / pow(10,power)
    	#print str(n1)
    	if(n1 > 0):
    		result = result+getString(n1)+" Million "
    	power-= 3
    	num = r1
    	r2 = num % pow(10,power)
    	n2 = num / pow(10,power)
    	if(n2 > 0):
    		result = result+getString(n2)+" Thousand "
    	num = r2
    	result = result + getString(num)
    	return result.strip()
        