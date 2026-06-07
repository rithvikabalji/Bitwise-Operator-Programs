#include <iostream>
using namespace std;

int maxSum = 0;

void calc(int matrix1[10][10], int r, int c, int row, int sum, int arr[])
{
    if(row == r)
    {
        if(sum > maxSum)
            maxSum = sum;
        return;
    }

    for(int col = 0; col < c; col++)
    {
        if(arr[col] == 0)
        {
            arr[col] = 1;

            calc(matrix1, r, c, row + 1, sum + matrix1[row][col], arr);

            arr[col] = 0;
        }
    }
}

int main()
{
    int r, c;
    int matrix1[10][10];
    int arr[10] = {0};

    cin >> r >> c;

    for(int i = 0; i < r; i++)
        for(int j = 0; j < c; j++)
            cin >> matrix1[i][j];

    calc(matrix1, r, c, 0, 0, arr);

    cout << maxSum;
}
