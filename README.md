# Lemoine's-Conjecture-Through-Parallel-Programming

 In 1894, French mathematician Émile Lemoine (1840–1912) made this conjecture:

    Every odd integer greater than 5 is the sum of a prime and twice a prime. 

In other words, if n is odd and n > 5, then n = p + 2q for some primes p and q. The primes p and q might or might not be the same. Note that p must be odd; q might be odd or even. There might be more than one solution to the formula. Here are some examples:

    7 = 3 + 2⋅2
    9 = 3 + 2⋅3 = 5 + 2⋅2
    11 = 5 + 2⋅3 = 7 + 2⋅2
    13 = 3 + 2⋅5 = 7 + 2⋅3
    15 = 5 + 2⋅5 = 11 + 2⋅2
    17 = 3 + 2⋅7 = 7 + 2⋅5 = 13 + 2⋅2
    19 = 5 + 2⋅7 = 13 + 2⋅3
    99 = 5 + 2⋅47 = 13 + 2⋅43 = 17 + 2⋅41 = 37 + 2⋅31 = 41 + 2⋅29 = 53 + 2⋅23 = 61 + 2⋅19 = 73 + 2⋅13 = 89 + 2⋅5
    199 = 5 + 2⋅97 = 41 + 2⋅79 = 53 + 2⋅73 = 113 + 2⋅43 = 137 + 2⋅31 = 173 + 2⋅13 = 193 + 2⋅3 

The conjecture has been verified for n up to 109. However, no one has been able to prove or disprove it in general. 


### Program Input and Output

 The program's command line arguments are the lower bound and upper bound of a range of integers. The lower bound must be an odd integer greater than 5. The upper bound must be an odd integer greater than or equal to the lower bound.

The program must iterate over all odd integers n from the lower bound to the upper bound inclusive. For each n, the program must find the smallest prime p such that n = p + 2q, where q is prime.

The program must print one and only one line of output, as in this example:
```
$ java pj2 LemoineSeq 1000001 1999999
1746551 = 1237 + 2*872657
```
The output line consists of the integer n, the string " = ", the integer p, the string " + 2*", and the integer q, terminated with a newline.

The program must print the n, p, and q values such that p is the largest among the integers n examined. If more that one integer yielded the same maximum p value, the program must print the one with the largest n value. 

### Software Specification

 The sequential version of the program must be run by typing this command line:

    java pj2 LemoineSeq <lb> <ub>

    <lb> is the lower bound integer to be examined (an odd integer greater than 5, type int).
    <ub> is the upper bound integer to be examined (an odd integer greater than or equal to <lb>, type int). 

Note: This means that the program's class must be named LemoineSeq, this class must not be in a package, and this class must extend class edu.rit.pj2.Task.

Note: The above command will work on the kraken computer. On the tardis computer, you must include the jar= option. For further information, see Parallel Java 2 on the RIT CS Parallel Computers.

The parallel version of the program must be run by typing this command line:

    java pj2 cores=<K> LemoineSmp <lb> <ub>

    <K> is the number of CPU cores to use; by default, this is also the number of threads in the parallel thread team.
    <lb> is the lower bound integer to be examined (an odd integer greater than 5).
    <ub> is the upper bound integer to be examined (an odd integer greater than or equal to <lb>). 

**If the command line does not have the required number of arguments, if any argument is erroneous, or if any other error occurs, the program must prints an error message on the console and terminate.**
