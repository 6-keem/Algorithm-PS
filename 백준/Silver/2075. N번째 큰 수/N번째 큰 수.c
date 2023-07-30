#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int key;
} element;

typedef struct {
	element heap[1500 * 1500 + 1];
	int heap_size;
}HeapType;

HeapType* create() {
	return (HeapType*)malloc(sizeof(HeapType));
}
void init(HeapType* h) {
	h->heap_size = 0;
}

void insert(HeapType* h, element item) {
	int index = ++(h->heap_size);
	while (index != 1 && item.key < h->heap[index / 2].key) {
		h->heap[index] = h->heap[index / 2];
		index /= 2;
	}
	h->heap[index] = item;
}

element delete(HeapType* h) {
	int parent = 1;
	int child = 2;
	element item = h->heap[1];
	element temp = h->heap[h->heap_size--];

	while (child <= h->heap_size) {
		if (child < h->heap_size && h->heap[child].key > h->heap[child + 1].key)
			child++;
		if (temp.key <= h->heap[child].key)
			break;
		h->heap[parent] = h->heap[child];
		parent = child;
		child *= 2;
	}
	h->heap[parent] = temp;
	return item;
}

int main() {
	HeapType* h = create();
	init(h);

	int n;
	scanf("%d", &n);
	int T = n * n;
	while (T--) {
		element data;
		scanf("%d", &data.key);
		insert(h, data);
	}

	int count = 0;
	while (count < ((n * n) - n)) {
		delete(h);
		count++;
	}
	element result = delete(h);
	printf("%d", result.key);
}