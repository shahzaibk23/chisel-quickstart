package lab8

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class task1Test extends FreeSpec with ChiselScalatestTester {
    "Task 2 Test " in {
        test(new memory_assignment).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.requestor(0).bits.poke(4.U)
            c.io.requestor(0).valid.poke(1.B)
            c.io.requestor(1).bits.poke(5.U)
            c.io.requestor(1).valid.poke(0.B)
            c.io.requestor(2).bits.poke(6.U)
            c.io.requestor(2).valid.poke(0.B)
            c.io.requestor(3).bits.poke(7.U)
            c.io.requestor(3).valid.poke(0.B)

            c.io.read_addr.poke(3.U)
            c.io.write_Addr.poke(3.U)

            c.clock.step(10)
            
        }
    }
}