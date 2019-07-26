#include<stdio.h>

int comp(char *str1, char * str2){
	if(strlen(str1)>strlen(str2)){
		return -1;
	}else if(strlen(str1)<strlen(str2)){
		return 1;
	}else{
		return 0;
	}
}

void main(){
	
	printf("%d \n", comp("apple", "banana"));
	printf("%d \n", comp("orange", "grape"));
	printf("%d \n", comp("kiwi", "kiwi"));
}