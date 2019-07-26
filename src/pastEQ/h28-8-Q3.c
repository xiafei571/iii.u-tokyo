#include<stdio.h>
int f(int *i, int *j){
	printf("%d, %d \n", *i, *j);
	*i += 4 + *j;
	printf("%d, %d \n", *i, *j);
	return *i + *j;
}

void main(){
	int x = 2;
	x = f(&x, &x);
	printf("%d \n", x);
}