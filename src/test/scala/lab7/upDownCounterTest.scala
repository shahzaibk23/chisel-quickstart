package lab7

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class upDownCounterTest extends FreeSpec with ChiselScalatestTester {
    "Up Down Counter Test" in {
        test(new CounterUpDown(8)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.data_in.poke(6.U)
            c.clock.step(40)
            c.io.data_in.poke(10.U)
            c.clock.step(50)
        }
    }
}