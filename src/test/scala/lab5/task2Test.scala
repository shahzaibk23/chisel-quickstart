package lab5

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class task2Test extends FreeSpec with ChiselScalatestTester {
    "Task 2 Test" in {
        test(new Router(UInt(32.W), UInt(32.W))).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.in.addr.poke(10.U)
            c.io.in.data.poke(12.U)
            c.io.out.addr.expect(10.U)
            c.io.out.data.expect(12.U)
        }
    }
}