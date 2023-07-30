#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
typedef struct {
    int key;
} element;
typedef struct {
    element heap[100001];
    int heap_size;
} HeapType;

HeapType* create() {
    return (HeapType*)malloc(sizeof(HeapType));
}

void init(HeapType* h) {
    h->heap_size = 0;
}

void insert(HeapType* h, element item) {
    int i = ++(h->heap_size);

    while (i != 1 && item.key < h->heap[i / 2].key) {
        h->heap[i] = h->heap[i / 2];
        i /= 2;
    }
    h->heap[i] = item;
}

element delete(HeapType* h) {
    if (h->heap_size == 0) {
        element rData;
        rData.key = 0;
        return rData;
    }

    int parent = 1;
    int child = 2;
    element item = h->heap[1];
    element temp = h->heap[(h->heap_size)--];

    while (child <= h->heap_size) {
        if (child < h->heap_size && (h->heap[child].key > h->heap[child + 1].key))
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
    int T;
    scanf("%d", &T);
    while (T--) {
        int command;
        scanf("%d", &command);
        element data;
        if (command == 0) {
            data = delete(h);
            printf("%d\n", data.key);
        }
        else {
            data.key = command;
            insert(h, data);
        }
    }
}