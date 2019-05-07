<img src="assets/logo.png" height="64px"/>

[![Build Status](https://travis-ci.com/lavinj87/toy-store.svg?branch=master)](https://travis-ci.com/lavinj87/toy-store) 

`Toy Store` is a **toy** implementation of a key-value in memory **store**.

## Contents
- [Quick Start](#quick-start)
- [Architecture](#architecture)

## Quick Start
Build the jar

Launch it with
 
```
java -cp toy-store.jar com.lavinj87.toy_store.server.Server [ip] [port] 
```

Open the client

```
java -cp toy-store.jar com.lavinj87.toy_store.client.Client [ip] [port]
```

and start executing commands:

```
toy-store@ip:client $ size
0
toy-store@ip:client $ set foo bar
ok
toy-store@ip:client $ get foo
bar
toy-store@ip:client $ get not-foo
null
toy-store@ip:client $ size
1
toy-store@ip:client $ del foo
bar
toy-store@ip:client $ size
0
```

## Architecture 
### The log
`Toy Store` is built on top the log abstraction. The log is an append-only storage. In our case the log consist on
all commands needed to put the store in its current state.

### Log Compression
Given that the log only operation is append, we will eventually run out of space. Because of that we introduce the 
concept of log compression.

Log compression is an operation whose result is the state of the store after applying an ordered collection of operations.

Let's illustrate with an example. Let `O` be the following ordered collection of operations:

``` 
1 set A a 
2 get B b
3 del B
4 get A
5 set C c
6 set A another-a
```

Let `E` be the state of an empty store. Let `E(O)=S` be the state of the store after applying `O` on `E`. Then:
```
A:another-a
C:c
```

Given that the operations are **deterministic** this is, applying `O` always on `E` always leads to `S`, we can 
replace `O` and simply use `S`.

This fact is useful because we can then replace a set of operations by its resulting state.

## Restoring state
The log is stored in a file, so that the state of the store can be recovered after restarts. By default is written in
the current folder in a file named `toy-store.log`

If you have a file containing the log you can restore the state corresponding to that log with

```
java -cp toy-store.jar com.lavinj87.toy_store.server.Server [ip] [port] --log-file=my_log_file 
```

By default the server will look for `toy-store.log` and if found, will try to load it. 
