// This script demonstrates the structure of a basic Java Maven project
// Note: This is just a representation, not actual file creation

console.log("Basic Java Maven Project Structure:");
console.log(`
my-java-project/
├── pom.xml                  # Maven project configuration
├── src/
│   ├── main/
│   │   ├── java/            # Java source files
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── App.java
│   │   └── resources/       # Application resources
│   └── test/
│       ├── java/            # Test source files
│       │   └── com/
│       │       └── example/
│       │           └── AppTest.java
│       └── resources/       # Test resources
└── README.md                # Project documentation
`);

console.log("\nExample pom.xml content:");
console.log(`
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>my-java-project</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
`);

console.log("\nExample App.java content:");
console.log(`
package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
`);

