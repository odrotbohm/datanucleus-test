# Datanucleus Sample Project

Tiny project to setup Datanucleus as JPA provider with runtime bytecode enhancement.

~~Currently this is failing due to the enhancement seemingly not being applied. Run `mvn clean test` to see both test cases (one using plain JPA, one trying to bootstrap JPA through Spring) failing with the error message that the class under test has not been enhanced.~~

It now works due to resolved ASM conflict.