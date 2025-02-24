#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void decompressFile() {
    FILE* compressed_fp = fopen("compressed.txt", "r");
    if (!compressed_fp) {
        printf("Error opening compressed file!\n");
        return;
    }

    FILE* codes_fp = fopen("codes.txt", "r");
    if (!codes_fp) {
        printf("Error opening codes file!\n");
        fclose(compressed_fp);
        return;
    }

    FILE* decompressed_fp = fopen("decompressed.txt", "w");
    if (!decompressed_fp) {
        printf("Error creating decompressed file!\n");
        fclose(compressed_fp);
        fclose(codes_fp);
        return;
    }

    char code[256];
    while (fscanf(codes_fp, "%s", code) != EOF) {
        int codeLen = strlen(code);
        char buffer = 0;
        int bufferPos = 0;
        for (int i = 0; i < codeLen; i++) {
            if (code[i] == '1') {
                buffer |= (1 << (7 - bufferPos));
            }
            bufferPos++;
            if (bufferPos == 8) {
                fputc(buffer, decompressed_fp);
                buffer = 0;
                bufferPos = 0;
            }
        }
    }

    fclose(compressed_fp);
    fclose(codes_fp);
    fclose(decompressed_fp);

    printf("Decompression completed.\n");
}

int main() {
    decompressFile();
    return 0;
}
