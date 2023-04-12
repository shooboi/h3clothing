import React from 'react'
import DataTable from 'react-data-table-component'
const Table = ({ columns, data, pagination = true }) => {
    return (
        <div>
            <DataTable columns={columns} data={data} pagination={pagination} />
        </div>
    )
}

export default Table