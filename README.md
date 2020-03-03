# java-shortuuid
[![Build Status](https://travis-ci.org/hsingh/java-shortuuid.svg?branch=master)](https://travis-ci.org/hsingh/java-shortuuid)

A generator library for concise, unambiguous and URL-safe UUIDs

A Java library that generates concise, unambiguous, URL-safe UUIDs. Based on and compatible with the Python library [`shortuuid`](https://github.com/stochastic-technologies/shortuuid). Inspired by the Go [implementation](https://github.com/renstrom/shortuuid).

Often, one needs to use non-sequential IDs in places where users will see them, but the IDs must be as concise and easy to use as possible. shortuuid solves this problem by generating UUIDs using and then translating them to base57 using lowercase and uppercase letters and digits, and removing similar-looking characters such as l, 1, I, O and 0.

## Usage

```
public String shortUuid() {
    ShortUuid.Builder builder = new ShortUuid.Builder();
    ShortUuid shortUuid = builder.build(UUID.randomUUID());
    
    return shortUuid.toString();
}

public UUID getUuid(String shortUuid) {
    ShortUuid.Builder builder = new ShortUuid.Builder();
 
    return UUID.fromString(builder.decode(shortUuid));
}
```

## Prosper-Specific Modifications

Functionally, there are no changes in our fork. But there have been project modifications to suit our needs:

1. Updated project to use Gradle wrapper
2. Changed project structure to support multiple modules, and moved the library source to the `lib` module
3. Added the `cli` module to the project, which contains the CLI wrapper around the library (see following section)
4. Removed `checkstyle` and `findbugs` plugins. They were causing more trouble than they were worth for our needs.

## CLI Wrapper

This module is a CLI wrapper around the main library. When the resulting .jar is executed, it will use the library to generate a new short UUID, and output it to stdout.

To use, run `java -jar short-uuid-cli.jar`
To build the executable jar, run `gradlew shadowJar`. It can be found in `<project-root>/cli/build/libs`.

## License

MIT
