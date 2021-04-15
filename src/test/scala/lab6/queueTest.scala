package lab6

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class queueTest extends FreeSpec with ChiselScalatestTester {
    "Queue Test" in {
        test(new queue).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.in.bits.poke(8.U)
            c.io.in.valid.poke(1.B)
           
            c.clock.step(10)
        }
    }
}