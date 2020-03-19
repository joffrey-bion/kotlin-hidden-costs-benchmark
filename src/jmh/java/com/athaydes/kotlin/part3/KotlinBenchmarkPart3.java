package com.athaydes.kotlin.part3;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import static java.util.Arrays.asList;

/**
 * https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-3-3bf6e0dbf0a4
 */
public class KotlinBenchmarkPart3 {

    @State( Scope.Benchmark )
    public static class TestState {
        int i = 44;
        String name = "John";
        SparseArray<String> sparseArray = new SparseArray<>( asList( "A", "B", "Hi", "ZZ", "FFF" ) );
    }

    @Benchmark
    public void javaSimplyInitializedProperty( Blackhole Blackhole ) {
        JavaExamples.runStringDelegateExample( Blackhole );
    }

    @Benchmark
    public void kotlinDelegateProperty( Blackhole Blackhole ) {
        Kotlin_sourcesKt.runStringDelegateExample( Blackhole );
    }

    @Benchmark
    public boolean kotlinLocallyDeclaredRange( TestState testState ) {
        return Kotlin_sourcesKt.runIsInOneToTenWithLocalRange( testState.i );
    }

    @Benchmark
    public boolean kotlinIndirectRange( TestState testState ) {
        return Kotlin_sourcesKt.runIsInOneToTenWithIndirectRange( testState.i );
    }

    @Benchmark
    public boolean javaStringComparisons( TestState testState ) {
        return JavaExamples.isBetweenNames( testState.name );
    }

    @Benchmark
    public boolean kotlinStringRangeInclusionWithLocalRange( TestState testState ) {
        return Kotlin_sourcesKt.isBetweenNamesWithLocalRange( testState.name );
    }

    @Benchmark
    public boolean kotlinStringRangeInclusionWithConstantRange( TestState testState ) {
        return Kotlin_sourcesKt.isBetweenNamesWithConstantRange( testState.name );
    }

    @Benchmark
    public void kotlinRangeForEachFunction( Blackhole Blackhole ) {
        Kotlin_sourcesKt.rangeForEachMethod( Blackhole );
    }

    @Benchmark
    public void kotlinRangeForEachLoop( Blackhole Blackhole ) {
        Kotlin_sourcesKt.rangeForEachLoop( Blackhole );
    }

    @Benchmark
    public void kotlinRangeForEachLoopWithStep1( Blackhole Blackhole ) {
        Kotlin_sourcesKt.rangeForEachLoopWithStep1( Blackhole );
    }

    @Benchmark
    public void kotlinCustomIndicesIteration( TestState testState, Blackhole Blackhole ) {
        Kotlin_sourcesKt.printValuesUsingIndices( testState.sparseArray, Blackhole );
    }

    @Benchmark
    public void kotlinIterationUsingLastIndexRange( TestState testState, Blackhole Blackhole ) {
        Kotlin_sourcesKt.printValuesUsingLastIndexRange( testState.sparseArray, Blackhole );
    }


}
