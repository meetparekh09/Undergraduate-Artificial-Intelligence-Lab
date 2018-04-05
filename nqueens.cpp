#include <stdio.h>

bool isConsistent(int q[], int n) {
	for(int i = 0; i < n; i++) {
		if(q[i] == q[n]) return false;
		if((q[i] - q[n]) == (n-i)) return false;
		if((q[n] - q[i]) == (n-i)) return false;
	}
	return true;
}

void printQueens(int q[], int N) {
	for(int i = 0; i < N; i++) {
		for(int j = 0; j < N; j++) {
			if(q[i] == j) printf("Q ");
			else printf("* ");
		}
		printf("\n");
	}
	printf("\n\n\n");
}

void enumerate(int q[], int n, int N) {
	if(n == N) printQueens(q, N);
	else {
		for(int i = 0; i < N; i++) {
			q[n] = i;
			if(isConsistent(q, n)) enumerate(q, n+1, N);
		}
	}
}

void enumerate(int N) {
	int *q = new int[N];
	enumerate(q, 0, N);
}

int main() {
	int N = 8;
	enumerate(N);
}