package lab2

import org.scalatest._ 
import chiseltest._ 
import chisel3._ 

class muxHotTest extends FreeSpec with ChiselScalatestTester {
    "Mux Hot Test" in {
        test(new MuxHot){ c =>
            c.io.in0.poke(10.U)
            c.io.in1.poke(11.U)
            c.io.in2.poke(12.U)
            c.io.in3.poke(13.U)
            c.io.sel.poke("b1000".U)
            c.clock.step(1)
            c.io.out.expect(13.U)
        }
    }
}