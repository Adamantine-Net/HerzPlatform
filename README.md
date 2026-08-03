# HerzPlatform

HerzPlatform is custom tailored high quality modding api for Eaglercraft developers of all versions.

# How it works

Most other developers always rely on hooking directly into the code which makes it harder to port to
new versions and/or try to not touch the games base code, instead of that we rely on a mixin based
system that me (notanorange) made, basically normal mixins inject changes live as the game is already
opened but ours does a few things.

# 1. Annotation-Based Mixin System

Standard mixins use complex live runtime changes to figure out what code to inject, instead of that we 
built a custom weaver that kinda acts as a compile time preprocessor ig you could call it.

When you write a mixin class inside this codebase, you use our custom annotations
(like @Inject, @Overwrite, @Shadow, @ModifyConstant). 
When Gradle is building the code, the MixinWeaver scans your code, reads those annotations, 
and directly rewrites the raw Minecraft bytecode (so the .class files).

This basically results in zero runtime overhead. By the time the JVM runs the game, your code is already
natively part of Minecraft's classes, (which also bypasses TeaVM's restrictions as it's an aot compiler so
there's little to no reflection or changes after compile <3).

# 2. The Event Bus

Since we have total control over the source, we can trigger our own custom events from anywhere inside the game loop
without altering the games actual code which allows EASE while modding!

So our EventBus is a like a center station ig you could call it. So when a mixin intercepts a Minecraft action 
(like a block breaking, a tick, or a packet), it wraps that data into an event and sends that to the bus.

This makes it so you don't need to make custom mixins for every single feature anymore, as you write one mixin 
to fire the event, and then you can write 100 different mods that just listen to that event.

# Building
Requires Java 17+ I think (Don't quote me on that lol)

**Do Everything (Merge + Build JS Client):**
```
# Jst make the mixins
./gradlew compileFull_1_8

# Build the js
./gradlew buildJavaScript_1_8

# Build the wasmgc client
./gradlew buildWasm_1_8
```

**Desktop Runtime**
```
./gradlew runDesktop_1_8
```

**Compile Everything**
```
# Builds every single supported Eagler version at once
./gradlew buildAllEagler

# Cleans all build outputs
./gradlew cleanAllEagler
```

**Compile Offline (UNFINISHED)**
Right now you have to go into the module you want to compile the offline download then run it in that
later we'll add a Gradle task here to compile the offline downloads w/o going into the modules.
```sh MakeOfflineDownload.sh or bash MakeOfflineDownload.sh or .bat whtver```



