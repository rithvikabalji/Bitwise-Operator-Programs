// Number Checker

#include <stdio.h>

int main() {
    char str[10001];
    int flag = 0;
    scanf("%s",str);
    
    for (int i = 0; str[i] != '\0'; i++){
        char ch = str[i];
        if (ch >= '0' && ch <= '9'){
            flag |= (1 << (ch - '0'));
        }
        
    }
    
    int temp = (1 << 10) - 1;
    
    printf( flag == temp ? "Yes" : "No");
    return 0;
}
