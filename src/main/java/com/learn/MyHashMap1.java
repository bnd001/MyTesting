package com.learn;

import java.util.LinkedList;

class HashMapNode<Integer>{
    Integer key;
    Integer value;

    HashMapNode(Integer key, Integer value){
        this.key = key;
        this.value = value;
    }
}

class MyHashMap1 {

    private LinkedList<HashMapNode>[] bucket;

    public MyHashMap1() {
        bucket = new LinkedList[10000];
        for(int i = 0; i<10000; i++){
            bucket[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int bucket_index  = hash_function(key); // key index
        int index = listIndex(key, bucket_index); //value index

        if(index == -1){
            //means we have to create new node and insert it
            HashMapNode<Integer> node = new HashMapNode<Integer>(key, value);
            if(bucket[bucket_index] != null)
                bucket[bucket_index].add(node);
        }
        else{
            HashMapNode<Integer> node = null;
            if(bucket[bucket_index] != null){
                node = bucket[bucket_index].get(index);

                node.value = value;
            }        }
    }

    public int get(int key) {
        int bucket_index  = hash_function(key); // key index
        int index = listIndex(key, bucket_index); //value index

        if(index == -1)
            return -1;
        else
            return (int)bucket[bucket_index].get(index).value;
    }

    public void remove(int key) {
        int bucket_index  = hash_function(key); // key index
        int index = listIndex(key, bucket_index); //value index

        if(index != -1){
            bucket[bucket_index].remove(index);
        }


    }
    private int hash_function(int key){
        return Integer.hashCode(key)%bucket.length;
    }

    private int listIndex(int key, int index){
        int list_index = 0;
        if(bucket[index] != null)
            for(HashMapNode<Integer> node : bucket[index]){

                if(node.key == key)
                    return list_index;
                list_index++;
            }
        return -1;
    }
}
