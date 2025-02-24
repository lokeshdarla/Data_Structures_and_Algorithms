#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_TREE_HT 256

struct MinHeapNode {
    char data;
    unsigned freq;
    struct MinHeapNode *left, *right;
};

struct MinHeap {
    unsigned size;
    unsigned capacity;
    struct MinHeapNode **array;
};

struct MinHeapNode* newNode(char data, unsigned freq) {
    struct MinHeapNode* temp = (struct MinHeapNode*)malloc(sizeof(struct MinHeapNode));
    temp->left = temp->right = NULL;
    temp->data = data;
    temp->freq = freq;
    return temp;
}

struct MinHeap* createMinHeap(unsigned capacity) {
    struct MinHeap* minHeap = (struct MinHeap*)malloc(sizeof(struct MinHeap));
    minHeap->size = 0;
    minHeap->capacity = capacity;
    minHeap->array = (struct MinHeapNode**)malloc(minHeap->capacity * sizeof(struct MinHeapNode*));
    return minHeap;
}

void swapMinHeapNode(struct MinHeapNode** a, struct MinHeapNode** b) {
    struct MinHeapNode* t = *a;
    *a = *b;
    *b = t;
}

void minHeapify(struct MinHeap* minHeap, int idx) {
    int smallest = idx;
    int left = 2 * idx + 1;
    int right = 2 * idx + 2;

    if (left < minHeap->size && minHeap->array[left]->freq < minHeap->array[smallest]->freq)
        smallest = left;

    if (right < minHeap->size && minHeap->array[right]->freq < minHeap->array[smallest]->freq)
        smallest = right;

    if (smallest != idx) {
        swapMinHeapNode(&minHeap->array[smallest], &minHeap->array[idx]);
        minHeapify(minHeap, smallest);
    }
}

int isSizeOne(struct MinHeap* minHeap) {
    return (minHeap->size == 1);
}

struct MinHeapNode* extractMin(struct MinHeap* minHeap) {
    struct MinHeapNode* temp = minHeap->array[0];
    minHeap->array[0] = minHeap->array[minHeap->size - 1];
    --minHeap->size;
    minHeapify(minHeap, 0);
    return temp;
}

void insertMinHeap(struct MinHeap* minHeap, struct MinHeapNode* minHeapNode) {
    ++minHeap->size;
    int i = minHeap->size - 1;
    while (i && minHeapNode->freq < minHeap->array[(i - 1) / 2]->freq) {
        minHeap->array[i] = minHeap->array[(i - 1) / 2];
        i = (i - 1) / 2;
    }
    minHeap->array[i] = minHeapNode;
}

void buildMinHeap(struct MinHeap* minHeap) {
    int n = minHeap->size - 1;
    int i;
    for (i = (n - 1) / 2; i >= 0; --i)
        minHeapify(minHeap, i);
}

int isLeaf(struct MinHeapNode* root) {
    return !(root->left) && !(root->right);
}

struct MinHeap* createAndBuildMinHeap(char data[], int freq[], int size) {
    struct MinHeap* minHeap = createMinHeap(size);
    minHeap->size = size;
    for (int i = 0; i < size; ++i) {
        minHeap->array[i] = newNode(data[i], freq[i]);
    }
    buildMinHeap(minHeap);
    return minHeap;
}

struct MinHeapNode* buildHuffmanTree(char data[], int freq[], int size) {
    struct MinHeapNode *left, *right, *top;
    struct MinHeap* minHeap = createAndBuildMinHeap(data, freq, size);
    while (!isSizeOne(minHeap)) {
        left = extractMin(minHeap);
        right = extractMin(minHeap);
        top = newNode('$', left->freq + right->freq);
        top->left = left;
        top->right = right;
        insertMinHeap(minHeap, top);
    }
    return extractMin(minHeap);
}

void printCodes(struct MinHeapNode* root, int arr[], int top) {
    if (root->left) {
        arr[top] = 0;
        printCodes(root->left, arr, top + 1);
    }
    if (root->right) {
        arr[top] = 1;
        printCodes(root->right, arr, top + 1);
    }
    if (isLeaf(root)) {
        printf("%c: ", root->data);
        for (int i = 0; i < top; ++i)
            printf("%d", arr[i]);
        printf("\n");
    }
}

void storeCodes(FILE* fp, struct MinHeapNode* root, int arr[], int top) {
    if (root->left) {
        arr[top] = 0;
        storeCodes(fp, root->left, arr, top + 1);
    }
    if (root->right) {
        arr[top] = 1;
        storeCodes(fp, root->right, arr, top + 1);
    }
    if (isLeaf(root)) {
        fprintf(fp, "%c:", root->data);
        for (int i = 0; i < top; ++i)
            fprintf(fp, "%d", arr[i]);
        fprintf(fp, "\n");
    }
}

void HuffmanCodes(char data[], int freq[], int size) {
    struct MinHeapNode* root = buildHuffmanTree(data, freq, size);
    int arr[MAX_TREE_HT], top = 0;
    FILE* fp = fopen("codes.txt", "w");
    storeCodes(fp, root, arr, top);
    fclose(fp);
}

void compressFile(char* input_file) {
    FILE* input_fp = fopen(input_file, "r");
    if (!input_fp) {
        printf("Error opening file!\n");
        return;
    }

    int freq[256] = {0};
    int ch;
    while ((ch = fgetc(input_fp)) != EOF) {
        freq[ch]++;
    }

    fclose(input_fp);

    char data[256];
    int dataSize = 0;
    for(int i = 0; i < 256; i++) {
        if(freq[i] > 0) {
            data[dataSize] = (char)i;
            dataSize++;
        }
    }

    HuffmanCodes(data, freq, dataSize);

    input_fp = fopen(input_file, "r");
    FILE* output_fp = fopen("compressed.txt", "w");
    if (!output_fp) {
        printf("Error creating compressed file!\n");
        fclose(input_fp);
        return;
    }

        FILE* codes_fp = fopen("codes.txt", "r");
        char code[256];
        char ch1;
        char co;

        while ((ch1 = fgetc(input_fp)) != EOF) {
            rewind(codes_fp);
            while (fscanf(codes_fp, "%c:%s", &co, code) != EOF) {
                int codeLen = strlen(code);
                if (co == ch1) {
                    for (int i = 0; i < codeLen; i++) {
                        fprintf(output_fp, "%c", code[i]);
                    }
                    break;
                }
            }
        }

 
   
    fseek(input_fp, 0, SEEK_END);
    long original_size = ftell(input_fp);
    fclose(input_fp);

    fseek(output_fp, 0, SEEK_END);
    long compressed_size = ftell(output_fp);
    fclose(output_fp);

    printf("Size of the original file: %ld bytes\n", original_size*8);
    printf("Size of the compressed file: %ld bytes\n", compressed_size*1);
}

int main() {
    char input_file[] = "sample.txt";
    compressFile(input_file);
    return 0;
}
