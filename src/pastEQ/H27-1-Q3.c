#include<stdio.h>

char* F(int n, int b){
	static char outb[66] = {0};
	int i = 64;
	for(;n>0 && i>0; --i, n/=b){
		outb[i] = "0123456789abcdefghijkl"[n%b];
	}

	return &outb[i+1];
}

int main(int argc, char const *argv[])
{
	/* code */
	printf("%s\n", F(428,16));
	printf("%s\n", F(226,4));
	printf("%s\n", F(10,2));
	return 0;
}