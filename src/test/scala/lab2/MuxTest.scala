package lab2

import org.scalatest._ 
import chiseltest._ 
import chisel3._ 


class MuxTest extends FreeSpec with ChiselScalatestTester {
    "Mux Test " in {
        test(new Mux_main){ c =>
            c.io.inA.poke(12.U)
            c.io.inB.poke(10.U)
            c.io.sel.poke(1.B)
            c.io.out.expect(12.U)
        }
    }
}