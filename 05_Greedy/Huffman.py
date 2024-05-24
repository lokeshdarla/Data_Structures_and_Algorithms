import heapq
import os
import json  # Import JSON module for encoding and decoding dictionaries

class HuffmanNode:
    def __init__(self, char, freq):
        self.char = char
        self.freq = freq
        self.left = None
        self.right = None

    def __lt__(self, other):
        return self.freq < other.freq

def count_frequency(text):
    frequency = {}
    for char in text:
        if char in frequency:
            frequency[char] += 1
        else:
            frequency[char] = 1
    return frequency

def build_huffman_tree(frequency):
    priority_queue = [HuffmanNode(char, freq) for char, freq in frequency.items()]
    heapq.heapify(priority_queue)
    
    while len(priority_queue) > 1:
        left = heapq.heappop(priority_queue)
        right = heapq.heappop(priority_queue)
        
        merged = HuffmanNode(None, left.freq + right.freq)
        merged.left = left
        merged.right = right
        
        heapq.heappush(priority_queue, merged)
    
    return priority_queue[0]

def encode_tree(node, prefix='', code={}):
    if node is not None:
        if node.char is not None:
            code[node.char] = prefix
        encode_tree(node.left, prefix + '0', code)
        encode_tree(node.right, prefix + '1', code)
    return code

def encode_text(text, encoding_table):
    encoded_text = ''
    for char in text:
        encoded_text += encoding_table[char]
    return encoded_text

def decode_text(encoded_text, root):
    decoded_text = ''
    current = root
    for bit in encoded_text:
        if bit == '0':
            current = current.left
        else:
            current = current.right
        
        if current.char is not None:
            decoded_text += current.char
            current = root
    return decoded_text

def compress_file(input_file):
    # Read text from file
    with open(input_file, 'r') as file:
        text = file.read()
    
    # Count frequency of characters
    frequency = count_frequency(text)
    
    # Build Huffman tree
    root = build_huffman_tree(frequency)
    
    # Generate encoding table
    encoding_table = encode_tree(root)
    
    # Write encoding table to a separate file
    with open('output' + '.json', 'w') as codes_file:
        json.dump(encoding_table, codes_file)
    
    # Encode text using Huffman coding
    encoded_text = encode_text(text, encoding_table)
    
    # Write compressed data to file
    output_file = input_file + '.compressed'
    with open(output_file, 'w') as file:
        file.write(encoded_text)
    
    # Print size of original and compressed files
    original_size = os.path.getsize(input_file)
    compressed_size = os.path.getsize(output_file)
    print("Size of the original file:", original_size, "bytes")
    print("Size of the compressed file:", compressed_size, "bytes")

def decompress_file(input_file):
    # Read compressed text from file
    with open(input_file, 'r') as file:
        encoded_text = file.read()
    
    # Build Huffman tree
    frequency = count_frequency(encoded_text)
    root = build_huffman_tree(frequency)
    
    # Decode text using Huffman decoding
    decoded_text = decode_text(encoded_text, root)
    
    # Write decompressed data to file
    output_file = input_file[:-11]  # Remove '.compressed' from file name
    with open(output_file, 'w') as file:
        file.write(decoded_text)

# Sample Input
filename = "sample.txt"

# Compress file and print size of compressed file
print("Compressing file...")
compress_file(filename)

# Decompress file
print("\nDecompressing file...")
decompress_file(filename + '.compressed')
